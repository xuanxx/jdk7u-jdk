/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 4848897 4778440
 * @summary updating collation for Norwegian
 */

import java.text.*;
import java.util.*;

public class Bug4848897 {

  /********************************************************
  *********************************************************/
  public static void main (String[] args) {

      int errors=0;
      Locale loc = new Locale ("no", "NO");   // Norwegian

      Locale.setDefault (loc);
      Collator col = Collator.getInstance ();

      String[] data = {"wird",
                       "vird",
                       "verd",
                       "werd",
                       "vard",
                       "ward"};

      String[] sortedData = {"vard",
                             "verd",
                             "vird",
                             "ward",
                             "werd",
                             "wird"};

      Arrays.sort (data, col);

      System.out.println ("Using " + loc.getDisplayName());
      for (int i = 0;  i < data.length;  i++) {
          System.out.println(data[i] + "  :  " + sortedData[i]);
          if (sortedData[i].compareTo(data[i]) != 0) {
              errors++;
          }
      }//end for

      if (errors > 0)
          throw new RuntimeException();
  }//end main

}//end class CollatorTest
