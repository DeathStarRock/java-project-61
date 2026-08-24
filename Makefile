setup:
	@if [ ! -d "code/app" ]; then \
		echo "Fixing Docker structure..."; \
		mkdir -p code/app; \
		mv * code/app/ 2>/dev/null || true; \
		mv .git* code/app/ 2>/dev/null || true; \
	fi
	cd code/app && ./gradlew clean install
# force cache clear