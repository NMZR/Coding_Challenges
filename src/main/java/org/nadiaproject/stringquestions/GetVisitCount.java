package org.nadiaproject.stringquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetVisitCount {


    class VisitCounter {
        Map<Long, Long> count(Map<String, UserStats>... visits) {
            if (visits == null) {
                return Collections.emptyMap();
            }

            return Arrays.stream(visits)
                    .filter(Objects::nonNull)
                    .flatMap(map -> map.entrySet().stream())
                    .filter(entry -> entry.getKey() != null && entry.getValue() != null)
                    .filter(entry -> entry.getValue().getVisitCount().isPresent())
                    .collect(Collectors.groupingBy(
                            entry -> Long.parseLong(entry.getKey()),
                            Collectors.summingLong(entry -> (long) entry.getValue().getVisitCount().orElse(0L))
                    ));
        }
    }

}
