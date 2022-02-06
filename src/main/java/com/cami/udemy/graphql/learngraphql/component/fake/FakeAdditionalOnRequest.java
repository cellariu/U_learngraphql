package com.cami.udemy.graphql.learngraphql.component.fake;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@DgsComponent
public class FakeAdditionalOnRequest {

    @DgsData(parentType = "Query", field = "additionalOnRequest")
    public String additionalOnRequest(
            @RequestHeader(name = "optionalHeader", required = false) String optionalHeader,
            @RequestHeader(name = "mandatoryHeader", required = true) String mandatoryHeader,
            @RequestParam(name = "optionalParam", required = false) String optionalParam,
            @RequestParam(name = "mandatoryParam", required = true) String mandatoryParam
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("Optional Header: " + optionalHeader);
        sb.append(", ");

        sb.append("Mandatory Header: " + mandatoryHeader);
        sb.append(", ");

        sb.append("Optional Param: " + optionalParam);
        sb.append(", ");

        sb.append("Mandatory Param: " + mandatoryParam);

        return sb.toString();
    }
}
