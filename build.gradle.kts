plugins {
	java
	war
	id("org.springframework.boot") version "2.7.8-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.popcorn"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation("javax.servlet:jstl")
	implementation("org.apache.directory.studio:org.apache.commons.io:2.4")

	// https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-java8time
	// implementation("org.thymeleaf.extras:thymeleaf-extras-java8time:3.0.4.RELEASE")
	implementation("com.oracle.database.jdbc:ojdbc8:21.8.0.0")


	compileOnly("org.projectlombok:lombok")
	testImplementation("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly ("com.oracle.database.jdbc:ojdbc8")

	// implementation("org.springframework.boot:spring-boot-starter-security")
	implementation ("org.json:json:20200518")
	// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
	implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
	// https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl
	implementation("org.codehaus.jackson:jackson-mapper-asl:1.9.13")
	implementation("org.apache.commons:commons-lang3:3.0")
	implementation("com.google.code.gson:gson:2.7")


}

tasks.withType<Test> {
	useJUnitPlatform()
}