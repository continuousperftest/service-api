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

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfomanceMetricServiceImpl implements PerfomanceMetricDashboardService {

  @Autowired
  private PerfomanceMetricDashboardRepository perfomanceMetricRepository;

  @Override
  public List<PerfMetricAggregation> getMetricsGroupedByLaunchId(String startDate, String endDate,
      String groups, int threadCount) {
    groups = getOrderedGroupsSplittedByComma(groups);
    return perfomanceMetricRepository.getMetricsGroupedByLaunchId(startDate, endDate, groups,
        threadCount);
  }

  private String getOrderedGroupsSplittedByComma(String groups) {
    if (groups.trim().contains(",")) {
      List<String> groupsSplittedByComma = Arrays.asList(groups.split(","));
      groupsSplittedByComma.sort((group1, group2) -> group1.compareTo(group2));
      return String.join(",", groupsSplittedByComma);
    } else {
      return groups;
    }
  }
}
