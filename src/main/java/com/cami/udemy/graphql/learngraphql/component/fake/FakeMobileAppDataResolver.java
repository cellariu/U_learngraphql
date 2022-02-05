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

        if (StringUtils.isNotBlank(filter.getAppId())) {
            if (!StringUtils.equals(StringUtils.defaultIfBlank(filter.getAppId(), StringUtils.EMPTY), mApp.getAppId())) {
                return false;
            }
        }

        if (StringUtils.isNotBlank(filter.getName())) {
            //if (!StringUtils.containsAny(StringUtils.defaultIfBlank(filter.getName(), StringUtils.EMPTY) , mApp.getName())) {
            if (!StringUtils.containsIgnoreCase(StringUtils.defaultIfBlank(filter.getName(), StringUtils.EMPTY) , mApp.getName())) {
                return false;
            }
        }

        if (StringUtils.isNotBlank(filter.getVersion())) {
            if(!StringUtils.contains(StringUtils.defaultIfBlank(filter.getVersion(), StringUtils.EMPTY), mApp.getVersion())) {
                return false;
            }
        }

        if(StringUtils.isNotBlank(filter.getPlatform())) {
            if (!mApp.getPlatform().contains(filter.getPlatform())) {
                return false;
            }
        }

        if (filter.getAuthor() != null && StringUtils.isNotBlank(filter.getAuthor().getName())) {
            if (!StringUtils.contains(filter.getAuthor().getName(), mApp.getAuthor().getName())) {
                return false;
            }
        }

        if (mApp.getDownloaded() < filter.getMinimumDownload()) {
            return false;
        }

        if (filter.getReleasedAfter() != null) {
            if (filter.getReleasedAfter().isAfter(mApp.getReleaseDate())) {
                return false;
            }
        }

        return true;
     }

}
