package org.me.games.card.dto.encounter;

import lombok.Data;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data public class Encounters {

    private List<Encounter> one;
    private List<Encounter> two;
    private List<Encounter> three;

    public Encounters() {
        this.one = initLevelOne();
        this.two = initLevelTwo();
    }

    public static List<Encounter> initLevelOne() {
        return Stream.of(new Encounter("Shattered Dungeon",
                        Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)), new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 0, 1, 0)),
                                new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 1, 0)), new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 2, 1, 0)))
                                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00033"),

                new Encounter("Hollow Cave", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 3, 0, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 4, 0, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00034"),

                new Encounter("The Deeps", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 3, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 4, 0, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 1, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00035"),

                new Encounter("Ash Gardens", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 1, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00035"),

                new Encounter("Road of Sacrifices", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00037"),

                new Encounter("Ashen Hollow", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 3, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 5, 0, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00038"),

                new Encounter("Dark Hollow", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 0, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00039"),

                new Encounter("Lightless Passage", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 1, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00040"),

                new Encounter("Ghostly Keep", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 1, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 2, 1, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00041"),

                new Encounter("The Forgotten", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(1, 2, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 4, 0, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00042"))
                .collect(Collectors.toList());
    }

    public static List<Encounter> initLevelTwo() {
        return Stream.of(new Encounter("Forgotten Gorge",
                        Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)), new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 2, 0)),
                                new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 0, 3, 0)), new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 0, 4, 0)))
                                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00043"),
                new Encounter("High Wall of Lothric", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 2, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 3, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 3, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00044"),
                new Encounter("Hollow Cell", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 4, 0, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 4, 1, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 4, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00045"),
                new Encounter("Burned Gardens", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 2, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 4, 0, 1)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00046"),
                new Encounter("Temple of the Deeps", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 2, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 6, 0, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 2, 3, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00047"),
                new Encounter("Sunrise Pass", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 2, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00048"),
                new Encounter("Stormwind Gorge", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 2, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 0, 2)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 1, 1, 2)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00049"),
                new Encounter("Demon Ruins", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 0, 1)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 0, 4, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00050"),
                new Encounter("Lost Labyrinth", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 1, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 1, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 0, 1)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00051"),
                new Encounter("Weathered Peak", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 0, 2, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 0, 1)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 0, 2, 1)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00052"),
                new Encounter("Black Dungeon", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 3, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 0, 1, 1)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 3, 1, 1)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00053"),
                new Encounter("Prison Tower", Stream.of(new AbstractMap.SimpleEntry<>(1, new EncounterRow(2, 0, 1, 0)),
                        new AbstractMap.SimpleEntry<>(2, new EncounterRow(2, 2, 1, 0)), new AbstractMap.SimpleEntry<>(3, new EncounterRow(2, 2, 2, 0)),
                        new AbstractMap.SimpleEntry<>(4, new EncounterRow(2, 2, 3, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)), true, "class_encounters_00054"))
                .collect(Collectors.toList());
    }
}
