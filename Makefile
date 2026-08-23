run-dist:
	build\install\app\bin\app.bat

setup:
	cd code/app && chmod +x gradlew && ./gradlew clean install