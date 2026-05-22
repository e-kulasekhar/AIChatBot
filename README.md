# AI ChatBot

A modern AI ChatBot application built using Java, Spring Boot, LangChain4j, and Groq/OpenAI API integration.  
This project demonstrates how Large Language Models (LLMs) can be integrated into Java backend applications using REST APIs.

---

## Features

- AI-powered chatbot responses
- LangChain4j integration
- REST API communication
- Spring Boot backend architecture
- Dynamic user input handling
- Clean and responsive chatbot UI
- Fast AI response generation

---

## Tech Stack

- Java
- Spring Boot
- LangChain4j
- Groq API / OpenAI API
- Maven
- HTML
- CSS

---

## Project Structure

```text
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ com.example.SpringBoot._UsingLangChain4jPractice
 ┃ ┃    ┣ Config
 ┃ ┃    ┣ Controller
 ┃ ┃    ┗ Service
 ┃ ┗ resources
 ┃    ┗ application.properties
```

---

## API Endpoint

```http
GET /chat?message=Hello
```

Example:

```text
http://localhost:8082/chat?message=Hello
```

---

## How To Run

### Clone Repository

```bash
git clone https://github.com/e-kulasekhar/AIChatBot.git
```

### Open Project

Import the project into:
- Spring Tool Suite (STS)
- IntelliJ IDEA
- Eclipse

### Configure API Key

Add your API key inside:

```properties
application.properties
```

Example:

```properties
groq.api.key=${GROQ_API_KEY}
```

---

## Future Improvements

- Chat history support
- Multiple AI model integration
- Database integration
- User authentication
- Streaming responses
- Frontend framework integration

---

## Author

**Kulasekhar**

- Java Full Stack Developer
- Spring Boot Developer
- AI Integration Enthusiast

---

## License

This project is created for learning and educational purposes.
