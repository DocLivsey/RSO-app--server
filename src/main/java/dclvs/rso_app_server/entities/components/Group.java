package dclvs.rso_app_server.entities.components;

import lombok.Getter;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public enum Group {
    UNDEFINED("undefined"),
    ThreeAM("3ПМ"), FourAM("4ПМ"),
    ThreeMM("3ММ"), FourMM("4ММ"),
    ThreeIT("3ИТ"), FourIT("4ИТ"),
    ELEVENTH("11"), TWELFTH("12"), THIRTEENTH("13"),
    TWENTY_FIRST("21"), TWENTY_SECOND("22"), TWENTY_THIRTEENTH("23");

    private final String titleRUS;

    Group(String titleRUS) {
        this.titleRUS = titleRUS;
    }

    public static Group fromTitle(String title) {
        AtomicReference<Group> returnableGroup = new AtomicReference<>();
        EnumSet.allOf(Group.class)
                .forEach(group -> {
                    if (group.getTitleRUS().strip().equalsIgnoreCase(
                            title.replaceAll(" ", "").strip())) {
                        returnableGroup.set(group);
                    }
                });
        return returnableGroup.get() != null ? returnableGroup.get() : UNDEFINED;
    }
}
