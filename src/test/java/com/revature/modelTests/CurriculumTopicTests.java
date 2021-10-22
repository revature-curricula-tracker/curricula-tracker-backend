package com.revature.modelTests;


import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.CurriculumTopic;

@SpringBootTest(classes=CurriculumTopic.class)
 class CurriculumTopicTests {

    // One big test
    @Test
    void testBean() {
        assertThat(CurriculumTopic.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }

    // Individual, well named tests

    @Test
    void shouldHaveANoArgsConstructor() {
        assertThat(CurriculumTopic.class, hasValidBeanConstructor());
    }

    @Test
    void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(CurriculumTopic.class, hasValidGettersAndSetters());
    }

    @Test
    void allPropertiesShouldInfluenceHashCode() {
        assertThat(CurriculumTopic.class, hasValidBeanHashCode());
    }

    @Test
    void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(CurriculumTopic.class, hasValidBeanEquals());
    }

    @Test
    void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(CurriculumTopic.class, hasValidBeanToString());
    }
}
