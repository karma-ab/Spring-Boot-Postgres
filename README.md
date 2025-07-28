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

### City Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/showCities` | Get all cities |
| POST | `/cityAdd` | Add a new city |

### Mayor Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/showMayors` | Get all mayors |
| POST | `/mayorAdd` | Add a new mayor |
| POST | `/city/mayor/add` | Associate a mayor with a city |

### Asset Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/sortAsset` | Get sorted assets |

### User Management (MongoDB)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/fetchUsers` | Get all users from MongoDB |
| POST | `/saveUsers` | Save users to MongoDB |

### Utility Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/startThreads` | Start multithreading demo |
| POST | `/jsonFlat` | Flatten JSON objects |

## 📝 Sample API Requests

### Add a City
```bash
curl -X POST http://localhost:8080/cityAdd \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New York",
    "population": 8000000
  }'
```

### Add a Mayor
```bash
curl -X POST http://localhost:8080/mayorAdd \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "age": 45
  }'
```

### Get All Cities
```bash
curl -X GET http://localhost:8080/showCities
```

### Associate Mayor with City
```bash
curl -X POST http://localhost:8080/city/mayor/add \
  -H "Content-Type: application/json" \
  -d '{
    "cityId": 1,
    "mayorId": 1
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
- **AOP Logging**: Method execution logging using aspects
- **Exception Handling**: Global exception handler with custom error responses
- **JSON Processing**: JSON flattening and manipulation
- **Multithreading**: Concurrent processing examples
- **Scheduled Tasks**: Background job processing

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
