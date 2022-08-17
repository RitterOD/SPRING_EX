package org.maslov.jhipsterdemo.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.maslov.jhipsterdemo.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@IntegrationTest
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
