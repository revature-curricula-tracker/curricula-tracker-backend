package com.revature.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Topic;
import com.revature.model.Curriculum;
import com.revature.model.Topic;
import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes=Topic.class)
public class TopicTests {
	
    // One big test
    @Test
    public void testBean() {
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
    public void shouldHaveANoArgsConstructor() {
        assertThat(Topic.class, hasValidBeanConstructor());
    }

    @Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(Topic.class, hasValidGettersAndSetters());
    }

    @Test
    public void allPropertiesShouldInfluenceHashCode() {
        assertThat(Topic.class, hasValidBeanHashCode());
    }

    @Test
    public void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(Topic.class, hasValidBeanEquals());
    }

    @Test
    public void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(Topic.class, hasValidBeanToString());
    }
	
}
