package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeBookDatasource;
import com.cami.udemy.graphql.learngraphql.types.Author;
import com.cami.udemy.graphql.learngraphql.types.Book;
import com.cami.udemy.graphql.learngraphql.types.ReleaseHistoryInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DgsComponent
public class FakeBookDataResolver {

    //  If we use @DgsQuery annotation,
    //      method name must be exactly as it is in course.graphql schema (books)
    //  If we use @DgsData annotation,
    //      - the method name does not matter, only the signature must match,
    //      - but the parentType must be exactly as in course.graphql
    //      - and the field is the name of the method from course.graphql
    //      - and if the method parameter is authorName and author in the schema, we need to add a @InputArgument
    @DgsData(parentType = "Query", field = "books")
    public List<Book> bookWrittenBy(@InputArgument(name = "author") String authorName) {

        if (StringUtils.isBlank(authorName)) {
            return FakeBookDatasource.BOOKS_LIST;
        }

        return FakeBookDatasource.BOOKS_LIST.stream()
                .filter(b -> StringUtils.containsIgnoreCase(b.getAuthor().getName(), authorName))
                .collect(Collectors.toList());
    }

    @DgsQuery
    public List<Book> booksByReleased(Integer year, Boolean printedEdition) {

        if (year == null || printedEdition == null) {
            return FakeBookDatasource.BOOKS_LIST;
        }

        return FakeBookDatasource.BOOKS_LIST.stream()
                .filter(b -> b.getReleased().getYear().compareTo(year) == 0 && b.getReleased().getPrintedEdition().compareTo(printedEdition) == 0)
                .collect(Collectors.toList());

    }

    @DgsData(parentType = "Query", field = "booksByReleased2")
    public List<Book> booksByReleased2(@InputArgument ReleaseHistoryInput releasedHistory) {

        if (releasedHistory == null) {
            return FakeBookDatasource.BOOKS_LIST;
        }

        if (releasedHistory.getYear() == null || releasedHistory.getPrintedEdition() == null) {
            return FakeBookDatasource.BOOKS_LIST;
        }

        return FakeBookDatasource.BOOKS_LIST.stream()
                .filter(b -> b.getReleased().getYear().compareTo(releasedHistory.getYear()) == 0 &&
                            b.getReleased().getPrintedEdition().compareTo(releasedHistory.getPrintedEdition()) == 0)
                .collect(Collectors.toList());

    }
}
