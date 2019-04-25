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

public class PerfMetricAggregation {

  private String launchId;
  private String launchDate;
  private float avgTimeRqExecution;
  private int count;

  public String getLaunchId() {
    return launchId;
  }

  public void setLaunchId(String launchId) {
    this.launchId = launchId;
  }

  public String getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(String launchDate) {
    this.launchDate = launchDate;
  }

  public float getAvgTimeRqExecution() {
    return avgTimeRqExecution;
  }

  public void setAvgTimeRqExecution(float avgTimeRqExecution) {
    this.avgTimeRqExecution = avgTimeRqExecution;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
