/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2009 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.motionchart;

import org.sonar.api.Extension;
import org.sonar.api.Plugin;
import org.sonar.api.Properties;
import org.sonar.api.Property;

import java.util.ArrayList;
import java.util.List;

@Properties({
    @Property(
        key = MotionChartPlugin.WIDTH_KEY,
        name = "Width",
        description = "Chart width in pixels.",
        defaultValue = MotionChartPlugin.DEFAULT_WIDTH),
    @Property(
        key = MotionChartPlugin.HEIGHT_KEY,
        name = "Height",
        description = "Chart height in pixels.",
        defaultValue = MotionChartPlugin.DEFAULT_HEIGHT),
    @Property(
        key = MotionChartPlugin.DEFAULT_METRICS_KEY,
        name = "Default axis metrics",
        description = "Comma-separated list of the 4 axis metrics loaded by default : X, Y, color, size.",
        defaultValue = MotionChartPlugin.DEFAULT_METRICS_VALUE),
    @Property(
        key = MotionChartPlugin.ADDITIONAL_METRICS_KEY,
        name = "Additional metrics",
        description = "Additional metrics which can be selected as axis.",
        defaultValue = MotionChartPlugin.ADDITIONAL_METRICS_DEFAULT_VALUE)
})
public class MotionChartPlugin implements Plugin {

  public static final String HEIGHT_KEY = "sonar.motionchart.height";
  public static final String WIDTH_KEY = "sonar.motionchart.width";
  public static final String DEFAULT_HEIGHT = "600";
  public static final String DEFAULT_WIDTH = "800";

  public static final String DEFAULT_METRICS_KEY = "sonar.motionchart.defaultmetrics";
  /**
   * Comma-separated list of the 4 axis metrics loaded by default : X, Y, color, size.
   */
  public static final String DEFAULT_METRICS_VALUE = "violations_density,coverage,function_complexity,complexity";

  public static final String ADDITIONAL_METRICS_KEY = "sonar.motionchart.additionalmetrics";

  public static final String ADDITIONAL_METRICS_DEFAULT_VALUE = "duplicated_lines_density,test_success_density,public_documented_api_density,uncovered_lines," +
      "comment_lines_density,ncloc,test_execution_time,weighted_violations,function_complexity";

  public String getKey() {
    return "motionchart";
  }

  public String getName() {
    return "Motion chart";
  }

  public String getDescription() {
    return "Motion chart";
  }

  public List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> extensions = new ArrayList<Class<? extends Extension>>();
    extensions.add(MotionChartPage.class);
    extensions.add(MotionChartWebService.class);
    return extensions;
  }

  @Override
  public String toString() {
    return getKey();
  }
}
