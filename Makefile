.PHONY: setup

setup:
	@echo "Checking repository content..."
	@ls -la || true
	@if [ ! -d "code/app" ]; then \
		echo "Docker cache bug detected! Recreating code/app on the fly..."; \
		mkdir -p code/app; \
		find . -maxdepth 1 ! -name '.' ! -name '..' ! -name 'code' -exec mv {} code/app/ \; 2>/dev/null || true; \
	fi
	@echo "Directory fixed. Current structure:"
	@ls -la code/app || true
	cd code/app && chmod +x gradlew && ./gradlew clean install