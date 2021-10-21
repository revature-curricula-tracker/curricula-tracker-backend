package com.revature.modelTests;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Curriculum;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes=Curriculum.class)
public class CurriculumTests {
	// One big test
    @Test
    public void testBean() {
        assertThat(Curriculum.class, allOf(
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
        assertThat(Curriculum.class, hasValidBeanConstructor());
    }

    @Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(Curriculum.class, hasValidGettersAndSetters());
    }

    @Test
    public void allPropertiesShouldInfluenceHashCode() {
        assertThat(Curriculum.class, hasValidBeanHashCode());
    }

    @Test
    public void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(Curriculum.class, hasValidBeanEquals());
    }

    @Test
    public void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(Curriculum.class, hasValidBeanToString());
    }
}
