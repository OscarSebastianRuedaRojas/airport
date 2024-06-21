#!/bin/bash

# Function to create directory structure
create_structure() {
  local name=$1
  
  mkdir -p ${name}/application/port/in
  mkdir -p ${name}/application/port/out
  mkdir -p ${name}/application/service
  mkdir -p ${name}/domain
  mkdir -p ${name}/infrastructure/adapter/in
  mkdir -p ${name}/infrastructure/adapter/out
  
  touch ${name}/application/port/in/${name}Service.java
  touch ${name}/application/port/out/${name}RepositoryPort.java
  touch ${name}/application/service/${name}Service.java
  touch ${name}/domain/${name}.java
  touch ${name}/infrastructure/adapter/in/${name}Controller.java
  touch ${name}/infrastructure/adapter/out/${name}Repository.java
}

# Check if a name was provided as a parameter
if [ -z "$1" ]; then
  echo "Please provide a name as a parameter."
  echo "Usage: $0 <name>"
  exit 1
fi

# Create structure with the provided name
create_structure "$1"

echo "Directory structure for '$1' created successfully."
