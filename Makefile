.PHONY: setup

setup:
	@echo "Running setup script..."
	@if [ ! -d "code/app" ]; then \
		mkdir -p code/app; \
		mv * code/app/ 2>/dev/null || true; \
	fi
	cd code/app && ./gradlew clean install