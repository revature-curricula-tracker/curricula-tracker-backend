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

import com.revature.model.Topic;

@SpringBootTest(classes=Topic.class)
class TopicTests {
	
    // One big test
    @Test
    void testBean() {
        assertThat(Topic.class, allOf(
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
        assertThat(Topic.class, hasValidBeanConstructor());
    }

    @Test
    void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(Topic.class, hasValidGettersAndSetters());
    }

    @Test
    void allPropertiesShouldInfluenceHashCode() {
        assertThat(Topic.class, hasValidBeanHashCode());
    }

    @Test
    void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(Topic.class, hasValidBeanEquals());
    }

    @Test
    void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(Topic.class, hasValidBeanToString());
    }
	
}
