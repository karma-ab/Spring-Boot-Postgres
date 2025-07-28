#!/bin/bash

# Update javax.persistence to jakarta.persistence
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.persistence/jakarta.persistence/g' {} \;

# Update javax.servlet to jakarta.servlet
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.servlet/jakarta.servlet/g' {} \;

# Update any other javax packages to jakarta
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.transaction/jakarta.transaction/g' {} \;
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.validation/jakarta.validation/g' {} \;
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.annotation/jakarta.annotation/g' {} \;
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.inject/jakarta.inject/g' {} \;
find /workspace/Spring-Boot-Postgres/src -name "*.java" -exec sed -i 's/javax\.ws/jakarta.ws/g' {} \;

echo "Import updates completed!"