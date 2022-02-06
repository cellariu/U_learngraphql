package com.cami.udemy.graphql.learngraphql.component.fake;

import com.cami.udemy.graphql.learngraphql.datasource.fake.FakeHelloDatasource;
import com.cami.udemy.graphql.learngraphql.types.Hello;
import com.cami.udemy.graphql.learngraphql.types.HelloInput;
import com.netflix.graphql.dgs.*;

import java.util.List;

@DgsComponent
public class FakeHelloMutation {

    //@DgsData(parentType = "Mutation", field = "addHello")
    @DgsMutation
    public Integer addHello(
            @InputArgument(name = "helloInput", collectionType = HelloInput.class) HelloInput helloInput) {

        var newHello = Hello.builder()
                .text(helloInput.getText())
                .randomNumber(helloInput.getNumber())
                .build();
        FakeHelloDatasource.HELLO_LIST.add(newHello);
        return FakeHelloDatasource.HELLO_LIST.size();
    }
    @DgsData(parentType = "Mutation", field = "replaceHelloText")
    public List<Hello> replaceHelloText(
            @InputArgument(name = "helloInput", collectionType = HelloInput.class) HelloInput helloInput) {

        FakeHelloDatasource.HELLO_LIST.stream()
                .filter(h -> h.getRandomNumber().equals(helloInput.getNumber()))
                .forEach(h -> h.setText(helloInput.getText()));

        return FakeHelloDatasource.HELLO_LIST;
    }

    @DgsData(parentType = "Mutation", field = "deleteHello")
    public Integer deleteHello(
            @InputArgument(name = "deleteHello", collectionType = Integer.class) Integer number) {

        FakeHelloDatasource.HELLO_LIST.removeIf(h -> h.getRandomNumber().equals(number));

        return FakeHelloDatasource.HELLO_LIST.size();
    }
}
