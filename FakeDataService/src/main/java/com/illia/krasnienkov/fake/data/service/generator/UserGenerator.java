package com.illia.krasnienkov.fake.data.service.generator;

import com.illia.krasnienkov.fake.data.service.modelDtos.Userr;

import java.time.ZoneId;

public class UserGenerator extends DataGenerator<Userr> {

    @Override
    public Userr initializeFields() {

        Userr userrDto = new Userr();
        userrDto.setName(faker.name().firstName());
        userrDto.setLastName(faker.name().lastName().replaceAll("'", "''"));
        userrDto.setSex(faker.demographic().sex().toUpperCase());
        userrDto.setDateOfBirthday(faker.date().birthday(12, 100)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .toString());
        userrDto.setTelephone(faker.phoneNumber().subscriberNumber(10));
        userrDto.setEmail(faker.internet().emailAddress());
        return userrDto;
    }
}
