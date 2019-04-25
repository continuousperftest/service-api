/*
 * Copyright 2018 Continuous Performance Test
 * 
 * 
 * This file is part of Continuous Performance Test.
 * https://github.com/continuousperftest/service-api
 * 
 * Continuous Performance Test is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 * 
 * Continuous Performance Test is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Continuous
 * Performance Test. If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.continuousperftest.dashboard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class PerfomanceMetricRepositoryImpl implements PerfomanceMetricDashboardRepository {

  private static final String COLLECTION_NAME = "metrics";

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public List<PerfMetricAggregation> getMetricsGroupedByLaunchId(String startDate, String endDate,
      String groups, int threadCount) {

    MatchOperation launchDataMatch =
        Aggregation.match(Criteria.where("environment.launchDate").gte(startDate).lte(endDate));
    MatchOperation threadCountMatch = Aggregation.match(
        Criteria.where("environment.executionArgs.threadcount").is(String.valueOf(threadCount)));
    MatchOperation testGroupsMatch =
        Aggregation.match(Criteria.where("environment.executionArgs.groups").is(groups));

    GroupOperation group =
        Aggregation.group("environment.launchId").avg("perfomance.executionTimeInMillis")
            .as("avgTimeRqExecution").count().as("count").first("environment.launchDate")
            .as("launchDate").first("environment.launchId").as("launchId");

    SortOperation sortBylaunchDate = Aggregation.sort(new Sort(Direction.ASC, "launchDate"));

    Aggregation aggregation = Aggregation.newAggregation(launchDataMatch, threadCountMatch,
        testGroupsMatch, group, sortBylaunchDate);

    AggregationResults<PerfMetricAggregation> output =
        mongoTemplate.aggregate(aggregation, COLLECTION_NAME, PerfMetricAggregation.class);
    return output.getMappedResults();
  }
}
