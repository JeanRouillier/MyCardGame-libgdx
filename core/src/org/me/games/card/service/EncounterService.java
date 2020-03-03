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
        return Stream.of(
                new Encounter("Shattered Dungeon", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 2, 1, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00033"),

                new Encounter("Hollow Cave", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 3, 0, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 4, 0, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00034"),

                new Encounter("The Deeps", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 3, 0, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 4, 0, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 1, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00035"),

                new Encounter("Ash Gardens", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 1, 1, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00035"),

                new Encounter("Road of Sacrifices", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00037"),

                new Encounter("Ashen Hollow", Stream.of(
                        new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 3, 0, 0)),
                        new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 5, 0, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00038")

                )
                .collect(Collectors.toList());
    }
}
