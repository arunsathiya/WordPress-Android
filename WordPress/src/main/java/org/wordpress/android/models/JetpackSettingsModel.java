package org.wordpress.android.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JetpackSettingsModel {
    public long localTableId;
    public boolean monitorActive;
    public boolean emailNotifications;
    public boolean wpNotifications;
    public boolean jetpackProtectEnabled;
    public final List<String> jetpackProtectWhitelist = new ArrayList<>();

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof JetpackSettingsModel)) return false;
        JetpackSettingsModel otherModel = (JetpackSettingsModel) other;
        return monitorActive == otherModel.monitorActive &&
                emailNotifications == otherModel.emailNotifications &&
                wpNotifications == otherModel.wpNotifications &&
                jetpackProtectEnabled == otherModel.jetpackProtectEnabled &&
                whitelistMatches(otherModel.jetpackProtectWhitelist);
    }

    public boolean whitelistMatches(List<String> otherWhitelist) {
        if (otherWhitelist == null) {
            return false;
        }

        Set<String> whitelistSet = new HashSet<>(jetpackProtectWhitelist);
        Set<String> otherSet = new HashSet<>(otherWhitelist);
        return whitelistSet.equals(otherSet);
    }
}
