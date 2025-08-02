# App Common Module

Đây là module Spring Boot chung chứa các thành phần cơ bản và utilities được sử dụng trong toàn bộ ứng dụng.

## Cấu trúc dự án

```
app-common/
├── pom.xml                    # Parent POM với dependency management
├── common-base/              # Module cơ bản chứa các class và utilities chung
├── common-domain/            # Module chứa domain models và entities
├── common-quartz/            # Module cấu hình và utilities cho Quartz scheduler
└── common-utility/           # Module chứa các utility classes và helper functions
```

## Các module

### 1. common-base
- **Mục đích**: Chứa các class cơ bản và utilities chung
- **Dependencies**: Spring Boot Starter, Lombok, Logging, Apache Commons, Jackson
- **Sử dụng**: Base classes, common annotations, basic utilities

### 2. common-domain
- **Mục đích**: Chứa domain models và entities
- **Dependencies**: common-base, Spring Data JPA, Validation, Transaction
- **Sử dụng**: Entity classes, domain models, repositories

### 3. common-quartz
- **Mục đích**: Cấu hình và utilities cho Quartz scheduler
- **Dependencies**: common-base, Quartz, Spring AOP, Transaction
- **Sử dụng**: Job configurations, scheduler utilities, cron expressions

### 4. common-utility
- **Mục đích**: Các utility classes và helper functions
- **Dependencies**: common-base, Spring Web, Mail, Cache, Security, JWT
- **Sử dụng**: HTTP utilities, email helpers, security utilities, JSON utilities

## Dependency Management

Tất cả versions được quản lý tập trung trong parent `pom.xml`:

- **Spring Boot**: 3.2.0
- **Spring Framework**: 6.1.0
- **Java**: 17
- **Database**: MySQL 8.0.33, PostgreSQL 42.7.0, H2 2.2.224
- **Logging**: Logback 1.4.11, SLF4J 2.0.9
- **Testing**: JUnit 5.10.0, Mockito 5.7.0
- **Utilities**: Lombok 1.18.30, Jackson 2.15.3, Apache Commons 3.13.0
- **Security**: Spring Security 6.2.0, JWT 0.12.3
- **Quartz**: 2.3.2

## Cách sử dụng

### 1. Build toàn bộ project
```bash
mvn clean install
```

### 2. Build từng module riêng lẻ
```bash
# Build common-base
mvn clean install -pl common-base

# Build common-domain
mvn clean install -pl common-domain

# Build common-quartz
mvn clean install -pl common-quartz

# Build common-utility
mvn clean install -pl common-utility
```

### 3. Sử dụng trong dự án khác
Thêm dependency vào `pom.xml` của dự án:

```xml
<dependency>
    <groupId>com.rustyapp</groupId>
    <artifactId>common-base</artifactId>
    <version>1.0.0</version>
</dependency>

<dependency>
    <groupId>com.rustyapp</groupId>
    <artifactId>common-domain</artifactId>
    <version>1.0.0</version>
</dependency>

<dependency>
    <groupId>com.rustyapp</groupId>
    <artifactId>common-quartz</artifactId>
    <version>1.0.0</version>
</dependency>

<dependency>
    <groupId>com.rustyapp</groupId>
    <artifactId>common-utility</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Tính năng chính

### Dependency Management
- Quản lý version tập trung, tránh conflict
- Sử dụng `dependencyManagement` để kiểm soát versions
- Các dependencies được phân loại rõ ràng theo chức năng

### Modular Design
- Mỗi module có trách nhiệm riêng biệt
- Dependencies được chia sẻ hợp lý
- Dễ dàng mở rộng và bảo trì

### Generic Configuration
- Cấu hình linh hoạt cho nhiều loại database
- Support cho nhiều loại logging
- Security configuration có thể tùy chỉnh

## Lưu ý

1. **Database Drivers**: Các database drivers được đánh dấu `optional=true` để tránh conflict khi deploy
2. **Testing**: Mỗi module đều có Spring Boot Test starter để testing
3. **Logging**: Sử dụng Logback làm logging framework chính
4. **Security**: JWT và Spring Security được tích hợp sẵn trong common-utility "# app-common" 
