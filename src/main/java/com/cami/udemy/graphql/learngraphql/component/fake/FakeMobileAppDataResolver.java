package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeMobileAppDatasource;
import com.cami.udemy.graphql.learngraphql.types.MobileApp;
import com.cami.udemy.graphql.learngraphql.types.MobileAppFilter;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@DgsComponent
public class FakeMobileAppDataResolver {

    @DgsData(parentType = "Query", field = "mobileApps")
    public List<MobileApp> mobileApps(
            @InputArgument(name = "mobileAppFilter", collectionType = MobileAppFilter.class) Optional<MobileAppFilter> oFilter) {

        if (oFilter.isEmpty()) {
            return FakeMobileAppDatasource.MOBILE_APPS;
        }

        MobileAppFilter filter = oFilter.get();

        return FakeMobileAppDatasource.MOBILE_APPS.stream()
                .filter(mobileApp -> checkIfMatch(mobileApp, filter))
                .collect(Collectors.toList());
    }

    private boolean checkIfMatch(MobileApp mApp, MobileAppFilter filter) {

        if (filter.getName() != null && !filter.getName().isBlank()) {
            if (!filter.getName().equals(mApp.getName())) {
                return false;
            }
        }

        if (filter.getVersion() != null && !filter.getVersion().isBlank()) {
            if(!filter.getVersion().contains(mApp.getVersion())) {
                return false;
            }
        }

        if (filter.getAuthor() != null && !filter.getAuthor().getName().isBlank()) {
            if(!filter.getAuthor().getName().equals(mApp.getAuthor().getName())) {
                return false;
            }
        }

        if(filter.getPlatform() != null && !filter.getPlatform().isBlank()) {
            if (!mApp.getPlatform().contains(filter.getPlatform())) {
                return false;
            }
        }

        return true;
     }

}
