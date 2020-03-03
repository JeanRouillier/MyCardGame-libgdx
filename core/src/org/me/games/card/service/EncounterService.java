package org.me.games.card.service;

import lombok.Data;
import org.me.games.card.dto.encounter.Encounter;
import org.me.games.card.dto.encounter.EncounterRow;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class EncounterService {

    private List<Encounter> one;
    private List<Encounter> two;
    private List<Encounter> three;

    public EncounterService(){
        this.one = initLevelOne();
    }

    public static List<Encounter> initLevelOne(){
        return Stream.of(new Encounter("Road of Sacrifices", Stream.of(
                //TODO set level 1 to 2
                new AbstractMap.SimpleEntry<Integer, EncounterRow>(1, new EncounterRow(1, 3, 0, 0)),
                new AbstractMap.SimpleEntry<Integer, EncounterRow>(2, new EncounterRow(1, 2, 0, 0)),
                new AbstractMap.SimpleEntry<Integer, EncounterRow>(3, new EncounterRow(2, 2, 1, 0)),
                new AbstractMap.SimpleEntry<Integer, EncounterRow>(4, new EncounterRow(2, 1, 2, 0)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00037"))
                .collect(Collectors.toList());
    }
}
