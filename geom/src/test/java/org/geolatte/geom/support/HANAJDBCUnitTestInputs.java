/*
 * This file is part of the GeoLatte project.
 *
 *     GeoLatte is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     GeoLatte is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with GeoLatte.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010 - 2012 and Ownership of code is shared by:
 * Qmino bvba - Romeinsestraat 18 - 3001 Heverlee  (http://www.qmino.com)
 * Geovise bvba - Generaal Eisenhowerlei 9 - 2140 Antwerpen (http://www.geovise.com)
 */

package org.geolatte.geom.support;

import org.geolatte.geom.*;

import static org.geolatte.geom.builder.DSL.*;

import static org.geolatte.geom.CrsMock.*;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 10/13/12
 */

public class HANAJDBCUnitTestInputs extends WktWkbCodecTestBase {

    public HANAJDBCUnitTestInputs() {

        addCase(1,
                "POINT(10 10)",
                "010100000000000000000024400000000000002440",
                point(crs, c(10, 10)));

        addCase(2,
                "POINT Z(10 10 0)",
                "0101000080000000000000244000000000000024400000000000000000",
                point(crsZ, c(10, 10, 0)));

        addCase(3,
                "POINT M(10 10 20)",
                "0101000040000000000000244000000000000024400000000000003440",
                point(crsM, cM(10, 10, 20)));

        addCase(4,
                "POINT ZM(10 10 20 30)",
                "01010000C00000000000002440000000000000244000000000000034400000000000003E40",
                point(crsZM, c(10, 10, 20, 30)));

        addCase(5, //-- broken format
                "MULTIPOINT(11 12, 20 20)",
                "010400000002000000010100000000000000000026400000000000002840010100000000000000000034400000000000003440",
                new MultiPoint<C2D>(point(crs, c(11, 12)), point(crs, c(20, 20))),
                false);

        addCase(6,
                "MULTIPOINT Z(11 12 13, 20 20 20)",
                "0104000080020000000101000080000000000000264000000000000028400000000000002A400101000080000000000000344000000000000034400000000000003440",
                new MultiPoint<C3D>(point(crsZ, c(11, 12, 13)), point(crsZ, c(20, 20, 20))),
                false);

        addCase(7,
                "MULTIPOINT M(11 12 13, 20 20 20)",
                "0104000040020000000101000040000000000000264000000000000028400000000000002A400101000040000000000000344000000000000034400000000000003440",
                new MultiPoint<C2DM>(point(crsM, cM(11, 12, 13)), point(crsM, cM(20, 20, 20))),
                false);

        addCase(8,
                "MULTIPOINT ZM(11 12 13 14,20 20 20 20)",
                "01040000C00200000001010000C0000000000000264000000000000028400000000000002A400000000000002C4001010000C00000000000003440000000000000344000000000000034400000000000003440",
                new MultiPoint<C3DM>(point(crsZM, c(11, 12, 13, 14)), point(crsZM, c(20, 20, 20, 20))),
                false);

        addCase(9,
                "MULTIPOINT((11 12),(20 20))",
                "010400000002000000010100000000000000000026400000000000002840010100000000000000000034400000000000003440",
                new MultiPoint<C2D>(point(crs, c(11, 12)), point(crs, c(20, 20))));

        addCase(10,
                "MULTIPOINT Z((11 12 13),(20 20 20))",
                "0104000080020000000101000080000000000000264000000000000028400000000000002A400101000080000000000000344000000000000034400000000000003440",
                new MultiPoint<C3D>(point(crsZ, c(11, 12, 13)), point(crsZ, c(20, 20, 20))));

        addCase(11,
                "MULTIPOINT M((11 12 13),(20 20 20))",
                "0104000040020000000101000040000000000000264000000000000028400000000000002A400101000040000000000000344000000000000034400000000000003440",
                new MultiPoint<C2DM>(point(crsM, cM(11, 12, 13)), point(crsM, cM(20, 20, 20))));

        addCase(12,
                "MULTIPOINT ZM((11 12 13 14),(20 20 20 20))",
                "01040000C00200000001010000C0000000000000264000000000000028400000000000002A400000000000002C4001010000C00000000000003440000000000000344000000000000034400000000000003440",
                new MultiPoint<C3DM>(point(crsZM, c(11, 12, 13, 14)), point(crsZM, c(20, 20, 20, 20))));

        addCase(13,
                "LINESTRING(10 10,20 20,50 50,34 34)",
                "01020000000400000000000000000024400000000000002440000000000000344000000000000034400000000000004940000000000000494000000000000041400000000000004140",
                linestring(crs, c(10, 10), c(20, 20), c(50, 50), c(34, 34)));


        LineString line3D = linestring(crsZ, c(10, 10, 20), c(20, 20, 20), c(50, 50, 50), c(34, 34, 34));

        addCase(14,
                "LINESTRING Z(10 10 20,20 20 20,50 50 50,34 34 34)",
                "010200008004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140",
                line3D);

        addCase(15,
                "LINESTRING M(10 10 20,20 20 20,50 50 50,34 34 34)",
                "010200004004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140",
                linestring(crsM, cM(10, 10, 20), cM(20, 20, 20), cM(50, 50, 50), cM(34, 34, 34)));

        addCase(16,
                "LINESTRING ZM(10 10 20 20,20 20 20 20,50 50 50 50,34 34 34 50)",
                "01020000C0040000000000000000002440000000000000244000000000000034400000000000003440000000000000344000000000000034400000000000003440000000000000344000000000000049400000000000004940000000000000494000000000000049400000000000004140000000000000414000000000000041400000000000004940",
                linestring(crsZM, c(10, 10, 20, 20), c(20, 20, 20, 20), c(50, 50, 50, 50), c(34, 34, 34, 50)));

        Polygon polygon2D = polygon(
                ring(crs, c(10, 10), c(20, 10), c(20, 20), c(20, 10), c(10, 10)),
                ring(crs, c(5, 5), c(5, 6), c(6, 6), c(6, 5), c(5, 5))
        );

        addCase(17,
                "POLYGON((10 10,20 10,20 20,20 10,10 10),(5 5,5 6,6 6,6 5,5 5))",
                "010300000002000000050000000000000000002440000000000000244000000000000034400000000000002440000000000000344000000000000034400000000000003440000000000000244000000000000024400000000000002440050000000000000000001440000000000000144000000000000014400000000000001840000000000000184000000000000018400000000000001840000000000000144000000000000014400000000000001440",
                polygon2D
        );

        Polygon polygon3D = polygon(
                ring(crsZ, c(10, 10, 0), c(20, 10, 0), c(20, 20, 0), c(20, 10, 0), c(10, 10, 0)),
                ring(crsZ, c(5, 5, 0), c(5, 6, 0), c(6, 6, 0), c(6, 5, 0), c(5, 5, 0))
        );

        addCase(18,
                "POLYGON Z((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))",
                "0103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                polygon3D);

        Polygon polygon2DM = polygon(
                ring(crsM, cM(10, 10, 0), cM(20, 10, 0), cM(20, 20, 0), cM(20, 10, 0), cM(10, 10, 0)),
                ring(crsM, cM(5, 5, 0), cM(5, 6, 0), cM(6, 6, 0), cM(6, 5, 0), cM(5, 5, 0))
        );

        addCase(19,
                "POLYGON M((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))",
                "0103000040020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                polygon2DM);

        Polygon polygon3DM = polygon(
                ring(crsZM, c(10, 10, 0, 7), c(20, 10, 0, 7), c(20, 20, 0, 7), c(20, 10, 0, 7), c(10, 10, 0, 7)),
                ring(crsZM, c(5, 5, 0, 7), c(5, 6, 0, 7), c(6, 6, 0, 7), c(6, 5, 0, 7), c(5, 5, 0, 7))
        );

        addCase(20,
                "POLYGON ZM((10 10 0 7,20 10 0 7,20 20 0 7,20 10 0 7,10 10 0 7),(5 5 0 7,5 6 0 7,6 6 0 7,6 5 0 7,5 5 0 7))",
                "01030000C002000000050000000000000000002440000000000000244000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000003440000000000000344000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000002440000000000000244000000000000000000000000000001C40050000000000000000001440000000000000144000000000000000000000000000001C400000000000001440000000000000184000000000000000000000000000001C400000000000001840000000000000184000000000000000000000000000001C400000000000001840000000000000144000000000000000000000000000001C400000000000001440000000000000144000000000000000000000000000001C40",
                polygon3DM);

        addCase(21,
                "MULTIPOLYGON(((10 10,20 10,20 20,20 10,10 10),(5 5,5 6,6 6,6 5,5 5)),((10 10,20 10,20 20,20 10,10 10),(5 5,5 6,6 6,6 5,5 5)))",
                "010600000002000000010300000002000000050000000000000000002440000000000000244000000000000034400000000000002440000000000000344000000000000034400000000000003440000000000000244000000000000024400000000000002440050000000000000000001440000000000000144000000000000014400000000000001840000000000000184000000000000018400000000000001840000000000000144000000000000014400000000000001440010300000002000000050000000000000000002440000000000000244000000000000034400000000000002440000000000000344000000000000034400000000000003440000000000000244000000000000024400000000000002440050000000000000000001440000000000000144000000000000014400000000000001840000000000000184000000000000018400000000000001840000000000000144000000000000014400000000000001440",
                multipolygon(polygon2D, polygon2D));

        MultiPolygon multiPolygon3D = multipolygon(polygon3D, polygon3D);
        addCase(22,
                "MULTIPOLYGON Z(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "01060000800200000001030000800200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                multiPolygon3D);

        MultiPolygon multiPolygon2DM = multipolygon(polygon2DM, polygon2DM);
        addCase(23,
                "MULTIPOLYGON M(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "01060000400200000001030000400200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000040020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                multiPolygon2DM);

        addCase(24,
                "MULTIPOLYGON ZM(((10 10 0 7,20 10 0 7,20 20 0 7,20 10 0 7,10 10 0 7),(5 5 0 7,5 6 0 7,6 6 0 7,6 5 0 7,5 5 0 7)),((10 10 0 7,20 10 0 7,20 20 0 7,20 10 0 7,10 10 0 7),(5 5 0 7,5 6 0 7,6 6 0 7,6 5 0 7,5 5 0 7)))",
                "01060000C00200000001030000C002000000050000000000000000002440000000000000244000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000003440000000000000344000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000002440000000000000244000000000000000000000000000001C40050000000000000000001440000000000000144000000000000000000000000000001C400000000000001440000000000000184000000000000000000000000000001C400000000000001840000000000000184000000000000000000000000000001C400000000000001840000000000000144000000000000000000000000000001C400000000000001440000000000000144000000000000000000000000000001C4001030000C002000000050000000000000000002440000000000000244000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000003440000000000000344000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000002440000000000000244000000000000000000000000000001C40050000000000000000001440000000000000144000000000000000000000000000001C400000000000001440000000000000184000000000000000000000000000001C400000000000001840000000000000184000000000000000000000000000001C400000000000001840000000000000144000000000000000000000000000001C400000000000001440000000000000144000000000000000000000000000001C40",
                multipolygon(polygon3DM, polygon3DM));


        addCase(25,
                "MULTILINESTRING((10 10,20 10,20 20,20 10,10 10),(5 5,5 6,6 6,6 5,5 5))",
                "01050000000200000001020000000500000000000000000024400000000000002440000000000000344000000000000024400000000000003440000000000000344000000000000034400000000000002440000000000000244000000000000024400102000000050000000000000000001440000000000000144000000000000014400000000000001840000000000000184000000000000018400000000000001840000000000000144000000000000014400000000000001440",
                multilinestring(linestring(crs, c(10, 10), c(20, 10), c(20, 20), c(20, 10), c(10, 10)),
                        linestring(crs, c(5, 5), c(5, 6), c(6, 6), c(6, 5), c(5, 5))));

        addCase(26,
                "MULTILINESTRING Z((10 10 5,20 10 5,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))",
                "010500008002000000010200008005000000000000000000244000000000000024400000000000001440000000000000344000000000000024400000000000001440000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000010200008005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                multilinestring(
                        linestring(crsZ, c(10, 10, 5), c(20, 10, 5), c(20, 20, 0), c(20, 10, 0), c(10, 10, 0)),
                        linestring(crsZ, c(5, 5, 0), c(5, 6, 0), c(6, 6, 0), c(6, 5, 0), c(5, 5, 0))
                ));

        addCase(27,
                "MULTILINESTRING M((10 10 7,20 10 7,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))",
                "010500004002000000010200004005000000000000000000244000000000000024400000000000001C40000000000000344000000000000024400000000000001C40000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000010200004005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                multilinestring(
                        linestring(crsM, cM(10, 10, 7), cM(20, 10, 7), cM(20, 20, 0), cM(20, 10, 0), cM(10, 10, 0)),
                        linestring(crsM, cM(5, 5, 0), cM(5, 6, 0), cM(6, 6, 0), cM(6, 5, 0), cM(5, 5, 0))
                ));

        addCase(28,
                "MULTILINESTRING ZM((10 10 0 7,20 10 0 7,20 20 0 7,20 10 0 7,10 10 0 7),(5 5 0 7,5 6 0 7,6 6 0 7,6 5 0 7,5 5 0 7))",
                "01050000C00200000001020000C0050000000000000000002440000000000000244000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000003440000000000000344000000000000000000000000000001C400000000000003440000000000000244000000000000000000000000000001C400000000000002440000000000000244000000000000000000000000000001C4001020000C0050000000000000000001440000000000000144000000000000000000000000000001C400000000000001440000000000000184000000000000000000000000000001C400000000000001840000000000000184000000000000000000000000000001C400000000000001840000000000000144000000000000000000000000000001C400000000000001440000000000000144000000000000000000000000000001C40",
                multilinestring(
                        linestring(crsZM, c(10, 10, 0, 7), c(20, 10, 0, 7), c(20, 20, 0, 7), c(20, 10, 0, 7), c(10, 10, 0, 7)),
                        linestring(crsZM, c(5, 5, 0, 7), c(5, 6, 0, 7), c(6, 6, 0, 7), c(6, 5, 0, 7), c(5, 5, 0, 7))));

        addCase(29,
                "GEOMETRYCOLLECTION(POINT(10 10),POINT(20 20))",
                "010700000002000000010100000000000000000024400000000000002440010100000000000000000034400000000000003440",
                geometrycollection(point(crs, c(10, 10)), point(crs, c(20, 20))));

        addCase(30,
                "GEOMETRYCOLLECTION Z(POINT(10 10 20),POINT(20 20 20))",
                "01070000800200000001010000800000000000002440000000000000244000000000000034400101000080000000000000344000000000000034400000000000003440",
                geometrycollection(point(crsZ, c(10, 10, 20)), point(crsZ, c(20, 20, 20)))
                );

        addCase(31,
                "GEOMETRYCOLLECTION M(POINT(10 10 20),POINT(20 20 20))",
                "01070000400200000001010000400000000000002440000000000000244000000000000034400101000040000000000000344000000000000034400000000000003440",
                geometrycollection(point(crsM, cM(10, 10, 20)), point(crsM, cM(20, 20, 20)))
                );

        addCase(32,
                "GEOMETRYCOLLECTION ZM(POINT(10 10 20 7),POINT(20 20 20 7))",
                "01070000C00200000001010000C00000000000002440000000000000244000000000000034400000000000001C4001010000C00000000000003440000000000000344000000000000034400000000000001C40",
                geometrycollection(point(crsZM, c(10, 10, 20, 7)), point(crsZM, c(20, 20, 20, 7))));

        addCase(33,
                "GEOMETRYCOLLECTION Z(LINESTRING(10 10 20,20 20 20,50 50 50,34 34 34),LINESTRING(10 10 20,20 20 20,50 50 50,34 34 34))",
                "010700008002000000010200008004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140010200008004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140",
                geometrycollection(line3D, line3D));

        addCase(34,
                "GEOMETRYCOLLECTION Z(POLYGON((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),POLYGON((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "01070000800200000001030000800200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                geometrycollection(polygon3D, polygon3D));

        MultiPoint<C3D> mp = multipoint(point(crsZ, c(10, 10, 10)), point(crsZ, c(20, 20, 20)));
        AbstractGeometryCollection gcmp = geometrycollection(mp, mp);
        addCase(35,
                "GEOMETRYCOLLECTION Z(MULTIPOINT(10 10 10, 20 20 20),MULTIPOINT(10 10 10, 20 20 20))",
                "0107000080020000000104000080020000000101000080000000000000244000000000000024400000000000002440010100008000000000000034400000000000003440000000000000344001040000800200000001010000800000000000002440000000000000244000000000000024400101000080000000000000344000000000000034400000000000003440",
                gcmp, false);

        addCase(36,
                "GEOMETRYCOLLECTION Z(MULTIPOINT((10 10 10),(20 20 20)),MULTIPOINT((10 10 10),(20 20 20)))",
                "0107000080020000000104000080020000000101000080000000000000244000000000000024400000000000002440010100008000000000000034400000000000003440000000000000344001040000800200000001010000800000000000002440000000000000244000000000000024400101000080000000000000344000000000000034400000000000003440",
                gcmp);

        addCase(37,
                "GEOMETRYCOLLECTION Z(MULTILINESTRING((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "010700008001000000010500008002000000010200008005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000010200008005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                geometrycollection(multilinestring(
                        linestring(crsZ, c(10, 10, 0), c(20, 10, 0), c(20, 20, 0), c(20, 10, 0), c(10, 10, 0)),
                        linestring(crsZ , c(5, 5, 0), c(5, 6, 0), c(6, 6, 0), c(6, 5, 0), c(5, 5, 0))
                )));

        addCase(38,
                "GEOMETRYCOLLECTION Z(MULTIPOLYGON(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))),MULTIPOLYGON(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))))",
                "0107000080020000000106000080020000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000010300008002000000050000000000000000002440000000000000244000000000000000000000000000003440000000000000244000000000000000000000000000003440000000000000344000000000000000000000000000003440000000000000244000000000000000000000000000002440000000000000244000000000000000000500000000000000000014400000000000001440000000000000000000000000000014400000000000001840000000000000000000000000000018400000000000001840000000000000000000000000000018400000000000001440000000000000000000000000000014400000000000001440000000000000000001060000800200000001030000800200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                geometrycollection(multiPolygon3D, multiPolygon3D));

        addCase(39,
                "GEOMETRYCOLLECTION Z(POINT(10 10 20),LINESTRING(10 10 20,20 20 20,50 50 50,34 34 34),POLYGON((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "01070000800300000001010000800000000000002440000000000000244000000000000034400102000080040000000000000000002440000000000000244000000000000034400000000000003440000000000000344000000000000034400000000000004940000000000000494000000000000049400000000000004140000000000000414000000000000041400103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                geometrycollection(point(crsZ, c(10, 10, 20)), line3D, polygon3D));

        MultiLineString mls = multilinestring(
                linestring(crsZ, c(10, 10, 0), c(20, 10, 0), c(20, 20, 0), c(20, 10, 0), c(10, 10, 0)),
                linestring(crsZ, c(5, 5, 0), c(5, 6, 0), c(6, 6, 0), c(6, 5, 0), c(5, 5, 0))
        );

//        addCase(40,
//                "GEOMETRYCOLLECTION(POINT(10 10 20),MULTIPOINT(10 10 10,20 20 20),LINESTRING(10 10 20,20 20 20,50 50 50,34 34 34),POLYGON((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),MULTIPOLYGON(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))),MULTILINESTRING((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
//                "010700008006000000010100008000000000000024400000000000002440000000000000344001040000800200000001010000800000000000002440000000000000244000000000000024400101000080000000000000344000000000000034400000000000003440010200008004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140010300008002000000050000000000000000002440000000000000244000000000000000000000000000003440000000000000244000000000000000000000000000003440000000000000344000000000000000000000000000003440000000000000244000000000000000000000000000002440000000000000244000000000000000000500000000000000000014400000000000001440000000000000000000000000000014400000000000001840000000000000000000000000000018400000000000001840000000000000000000000000000018400000000000001440000000000000000000000000000014400000000000001440000000000000000001060000800200000001030000800200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000010500008002000000010200008005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000010200008005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
//                new GeometryCollection(new Geometry[]{
//                        Points.create3D(10, 10, 20), mp, line3D, polygon3D, multiPolygon3D, mls
//                }), false);

        addCase(41,
                "GEOMETRYCOLLECTION Z(POINT(10 10 20),MULTIPOINT((10 10 10),(20 20 20)),LINESTRING(10 10 20,20 20 20,50 50 50,34 34 34),POLYGON((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),MULTIPOLYGON(((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0))),MULTILINESTRING((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))",
                "010700008006000000010100008000000000000024400000000000002440000000000000344001040000800200000001010000800000000000002440000000000000244000000000000024400101000080000000000000344000000000000034400000000000003440010200008004000000000000000000244000000000000024400000000000003440000000000000344000000000000034400000000000003440000000000000494000000000000049400000000000004940000000000000414000000000000041400000000000004140010300008002000000050000000000000000002440000000000000244000000000000000000000000000003440000000000000244000000000000000000000000000003440000000000000344000000000000000000000000000003440000000000000244000000000000000000000000000002440000000000000244000000000000000000500000000000000000014400000000000001440000000000000000000000000000014400000000000001840000000000000000000000000000018400000000000001840000000000000000000000000000018400000000000001440000000000000000000000000000014400000000000001440000000000000000001060000800200000001030000800200000005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000050000000000000000001440000000000000144000000000000000000000000000001440000000000000184000000000000000000000000000001840000000000000184000000000000000000000000000001840000000000000144000000000000000000000000000001440000000000000144000000000000000000103000080020000000500000000000000000024400000000000002440000000000000000000000000000034400000000000002440000000000000000000000000000034400000000000003440000000000000000000000000000034400000000000002440000000000000000000000000000024400000000000002440000000000000000005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000010500008002000000010200008005000000000000000000244000000000000024400000000000000000000000000000344000000000000024400000000000000000000000000000344000000000000034400000000000000000000000000000344000000000000024400000000000000000000000000000244000000000000024400000000000000000010200008005000000000000000000144000000000000014400000000000000000000000000000144000000000000018400000000000000000000000000000184000000000000018400000000000000000000000000000184000000000000014400000000000000000000000000000144000000000000014400000000000000000",
                geometrycollection(point(crsZ, c(10, 10, 20)), mp, line3D, polygon3D, multiPolygon3D, mls)
        );

        addCase(42, "GEOMETRYCOLLECTION EMPTY", "010700000000000000", geometrycollection(crs));

        addCase(43, "POINT EMPTY", "010400000000000000", new Point(crs));
        addCase(44, "LINESTRING EMPTY", "010200000000000000", linestring(crs));
        addCase(45, "POLYGON EMPTY", "010300000000000000", polygon(crs));
        addCase(46, "MULTIPOINT EMPTY", "010400000000000000", multipoint(crs));

        addCase(47, "GEOMETRYCOLLECTION(POINT(4 0),POINT EMPTY,LINESTRING(4 2,5 3))",
                "0107000000030000000101000000000000000000104000000000000000000104000000000000000102000000020000000000000000001040000000000000004000000000000014400000000000000840",
                geometrycollection(point(crs, c(4, 0)), new Point(crs), linestring(crs, c(4, 2), c(5, 3)))
        );

    }
}