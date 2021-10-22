package com.revature.modelTests;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.CurriculumTopicKey;
@SpringBootTest(classes=CurriculumTopicKey.class)
 class CurriculumTopicKeyTests {
	
	// One big test
    @Test
     void testBean() {
        assertThat(CurriculumTopicKey.class, allOf(
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
        assertThat(CurriculumTopicKey.class, hasValidBeanConstructor());
    }

    @Test
    void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(CurriculumTopicKey.class, hasValidGettersAndSetters());
    }

    @Test
    void allPropertiesShouldInfluenceHashCode() {
        assertThat(CurriculumTopicKey.class, hasValidBeanHashCode());
    }

    @Test
    void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(CurriculumTopicKey.class, hasValidBeanEquals());
    }

    @Test
    void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(CurriculumTopicKey.class, hasValidBeanToString());
    }

}
