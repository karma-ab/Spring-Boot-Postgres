# Spring Boot PostgreSQL & MongoDB Demo Application

A comprehensive Spring Boot application demonstrating integration with PostgreSQL and MongoDB databases, featuring REST APIs, AOP logging, multithreading, scheduled tasks, and various Spring Boot features.

## 🚀 Features

- **Dual Database Support**: PostgreSQL for relational data and MongoDB for document storage
- **RESTful APIs**: Complete CRUD operations for cities, mayors, and assets
- **AOP Logging**: Aspect-oriented programming for method execution logging
- **Multithreading**: Demonstration of concurrent processing
- **Scheduled Tasks**: Background job processing
- **JSON Processing**: JSON flattening and manipulation utilities
- **Exception Handling**: Global exception handling with custom error responses
- **Security Configuration**: Basic Spring Security setup
- **Profile-based Configuration**: Development and production environment support
- **Data Transfer Objects (DTOs)**: Clean separation between entities and API responses

## 🛠 Technology Stack

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA** - For PostgreSQL integration
- **Spring Data MongoDB** - For MongoDB integration
- **Spring Security** - For authentication and authorization
- **Spring AOP** - For cross-cutting concerns
- **PostgreSQL** - Primary relational database
- **MongoDB** - Document database for user data
- **Maven** - Build and dependency management
- **JUnit 5** - Testing framework

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **PostgreSQL 12+**
- **MongoDB 4.4+** (optional, for MongoDB features)

## 🗄️ Database Setup

### PostgreSQL Setup

1. Install PostgreSQL and create a database:
```sql
CREATE DATABASE javaDB;
```

2. Create a user (optional):
```sql
CREATE USER postgres WITH PASSWORD 'root';
GRANT ALL PRIVILEGES ON DATABASE javaDB TO postgres;
```

3. The application will automatically create tables using Hibernate DDL auto-update.

### MongoDB Setup (Optional)

1. Install MongoDB
2. Start MongoDB service
3. The application will automatically connect to the default MongoDB instance on localhost:27017

## ⚙️ Configuration

The application uses `application.properties` for configuration. Key settings:

```properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/javaDB
spring.datasource.username=postgres
spring.datasource.password=root

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect

# MongoDB Configuration (uncomment if using MongoDB)
# spring.data.mongodb.database=user_db
# spring.data.mongodb.port=27017
# spring.data.mongodb.host=localhost
```

## 🚀 Running the Application

### Using Maven

1. Clone the repository:
```bash
git clone https://github.com/karma-ab/Spring-Boot-Postgres.git
cd Spring-Boot-Postgres
```

2. Build the application:
```bash
./mvnw clean compile
```

3. Run the application:
```bash
./mvnw spring-boot:run
```

### Using JAR

1. Build the JAR file:
```bash
./mvnw clean package -DskipTests
```

2. Run the JAR:
```bash
java -jar target/ProjectNotice-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## 📚 API Endpoints

### 🆕 RESTful API v1 (Recommended)

The application now provides modern RESTful endpoints following REST conventions:

#### Cities API (`/api/v1/cities`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/cities` | Get all cities |
| POST | `/api/v1/cities` | Create new cities |
| POST | `/api/v1/cities/{cityId}/mayors` | Assign mayors to a city |

#### Mayors API (`/api/v1/mayors`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/mayors` | Get all mayors |
| POST | `/api/v1/mayors` | Create new mayors |

#### Assets API (`/api/v1/assets`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/assets` | Get sorted assets |
| GET | `/api/v1/assets?sort=price` | Get assets sorted by price |

#### Users API (`/api/v1/users`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/users` | Get all users from MongoDB |
| POST | `/api/v1/users` | Create new users in MongoDB |

#### Utilities API (`/api/v1/utilities`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/utilities/threads/start` | Start multithreading demo |
| POST | `/api/v1/utilities/json/flatten` | Flatten JSON objects |

### ⚠️ Legacy Endpoints (Deprecated)

The following endpoints are deprecated and will be removed in future versions. Please migrate to the RESTful API above.

| Method | Endpoint | Description | New Endpoint |
|--------|----------|-------------|--------------|
| GET | `/showCities` | Get all cities | `GET /api/v1/cities` |
| POST | `/cityAdd` | Add a new city | `POST /api/v1/cities` |
| GET | `/showMayors` | Get all mayors | `GET /api/v1/mayors` |
| POST | `/mayorAdd` | Add a new mayor | `POST /api/v1/mayors` |
| POST | `/addCityMayor` | Associate mayor with city | `POST /api/v1/cities/{cityId}/mayors` |
| GET | `/sortAsset` | Get sorted assets | `GET /api/v1/assets` |
| GET | `/fetchUsers` | Get all users | `GET /api/v1/users` |
| POST | `/saveUsers` | Save users | `POST /api/v1/users` |
| GET | `/startThreads` | Start threads | `POST /api/v1/utilities/threads/start` |
| POST | `/getJsonFlat` | Flatten JSON | `POST /api/v1/utilities/json/flatten` |

## 📝 Sample API Requests

### RESTful API Examples

#### Get All Cities
```bash
curl -X GET http://localhost:8080/api/v1/cities \
  -H "Accept: application/json"
```

#### Create Cities
```bash
curl -X POST http://localhost:8080/api/v1/cities \
  -H "Content-Type: application/json" \
  -d '[
    {
      "name": "New York",
      "population": 8000000
    },
    {
      "name": "Los Angeles", 
      "population": 4000000
    }
  ]'
```

#### Create Mayors
```bash
curl -X POST http://localhost:8080/api/v1/mayors \
  -H "Content-Type: application/json" \
  -d '[
    {
      "name": "John Doe",
      "age": 45
    },
    {
      "name": "Jane Smith",
      "age": 52
    }
  ]'
```

#### Get All Mayors
```bash
curl -X GET http://localhost:8080/api/v1/mayors \
  -H "Accept: application/json"
```

#### Assign Mayor to City
```bash
curl -X POST http://localhost:8080/api/v1/cities/1/mayors \
  -H "Content-Type: application/json" \
  -d '[
    {
      "mayorId": 1
    }
  ]'
```

#### Get Assets
```bash
curl -X GET http://localhost:8080/api/v1/assets \
  -H "Accept: application/json"
```

#### Create Users
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '[
    {
      "name": "John Doe"
    },
    {
      "name": "Jane Smith"
    }
  ]'
```

#### Start Background Threads
```bash
curl -X POST http://localhost:8080/api/v1/utilities/threads/start \
  -H "Content-Type: application/json"
```

#### Flatten JSON
```bash
curl -X POST http://localhost:8080/api/v1/utilities/json/flatten \
  -H "Content-Type: application/json" \
  -d '{
    "user": {
      "name": "John",
      "address": {
        "city": "New York",
        "zip": "10001"
      }
    }
  }'
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/project/demo/
│   │   ├── aopConfig/          # AOP configuration and aspects
│   │   ├── comparator/         # Custom comparators
│   │   ├── controller/         # REST controllers
│   │   │   ├── CityController.java        # Legacy controller (deprecated)
│   │   │   ├── CityRestController.java    # RESTful cities API
│   │   │   ├── MayorRestController.java   # RESTful mayors API
│   │   │   ├── AssetRestController.java   # RESTful assets API
│   │   │   ├── UserRestController.java    # RESTful users API
│   │   │   └── UtilityRestController.java # RESTful utilities API
│   │   ├── cors/              # CORS configuration
│   │   ├── dto/               # Data Transfer Objects
│   │   ├── entity/            # JPA entities
│   │   ├── exception/         # Exception handling
│   │   ├── mongoEntity/       # MongoDB entities
│   │   ├── profileConfig/     # Profile-specific configurations
│   │   ├── repository/        # Data repositories
│   │   ├── security/          # Security configuration
│   │   ├── service/           # Business logic services
│   │   └── thread/            # Multithreading utilities
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
    └── java/                  # Test classes
```

## 🔧 Key Components

### Entities
- **CityMaster**: Represents cities with population data
- **MayorMaster**: Represents mayors with personal information
- **CityMayor**: Junction entity linking cities and mayors
- **AssetInventory**: Asset management entity
- **UserEntity**: MongoDB document for user data

### Services
- **CityService**: Business logic for city operations
- **AssetService**: Asset management operations
- **MongoService**: MongoDB operations
- **ThreadService**: Multithreading demonstrations
- **ScheduledClassService**: Background task scheduling

### Features Demonstrated
- **RESTful API Design**: Modern REST endpoints with proper HTTP methods and status codes
- **API Versioning**: Versioned API endpoints (`/api/v1/`) for backward compatibility
- **Resource-based URLs**: Clean, intuitive URL structure following REST conventions
- **AOP Logging**: Method execution logging using aspects
- **Exception Handling**: Global exception handler with custom error responses
- **JSON Processing**: JSON flattening and manipulation
- **Multithreading**: Concurrent processing examples
- **Scheduled Tasks**: Background job processing
- **Backward Compatibility**: Legacy endpoints maintained while encouraging migration

## 🧪 Testing

Run the tests using:
```bash
./mvnw test
```

Note: Tests require a running PostgreSQL database with the configured connection details.

## 📊 Logging

The application uses SLF4J with Logback for logging:
- Log files are stored in the `logs/` directory
- Console logging with colored output
- File logging with detailed format including timestamps and thread information

## 🔒 Security

The application includes basic Spring Security configuration:
- CORS support for cross-origin requests
- Basic authentication setup (can be extended as needed)

## 🌍 Environment Profiles

The application supports different profiles:
- **Development**: Enhanced logging and debugging features
- **Production**: Optimized for production deployment

Activate a profile using:
```bash
java -jar target/ProjectNotice-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 📞 Support

If you have any questions or issues, please open an issue on GitHub or contact the maintainers.

---

**Happy Coding! 🎉**
