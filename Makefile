setup:
	echo "Resetting docker cache..."
	cd code/app && ./gradlew clean install

# force cache clear