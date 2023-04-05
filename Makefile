run-dist:
	.\build\install\EnglishCards\bin\EnglishCards

clean-install:
	./gradlew clean installDist

build:
	./gradlew clean build


test:
	./gradlew test


clean-run: clean-install run-dist

install:
	./gradlew clean install

.PHONY: build