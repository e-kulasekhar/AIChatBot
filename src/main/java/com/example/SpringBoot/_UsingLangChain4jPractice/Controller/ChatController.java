package com.example.SpringBoot._UsingLangChain4jPractice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot._UsingLangChain4jPractice.Service.Assistant;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final Assistant assistant;

    public ChatController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/")
    public String home() {
        return "Application Running";
    }

    @GetMapping
    @ResponseBody
    public String chat(@RequestParam String message) {

        String response = assistant.chat(message);

        return """
                <html>

                <head>

                    <title>AI ChatBot</title>
<style>

    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
    }

    body{

        background:#0f172a;

        min-height:100vh;

        display:flex;

        justify-content:center;

        align-items:flex-start;

        padding:30px;

        font-family:Verdana,sans-serif;

        color:#f8fafc;
    }

    .card{

        width:1000px;

        max-width:100%%;

        background:#111827;

        border-radius:20px;

        padding:35px;

        border:1px solid #334155;

        box-shadow:
        0 10px 30px rgba(0,0,0,0.6);

    }

    h1{

        text-align:center;

        color:#ffffff;

        margin-bottom:35px;

        font-size:38px;

        font-weight:bold;

        letter-spacing:1px;
    }

    .user{

        background:#1e293b;

        border-left:5px solid #3b82f6;

        padding:22px;

        border-radius:15px;

        margin-bottom:25px;

        font-size:20px;

        line-height:1.8;

        color:#f8fafc;

    }

    .ai{

        background:#172554;

        border-left:5px solid #22c55e;

        padding:22px;

        border-radius:15px;

        overflow-x:auto;

    }

    pre{

        white-space:pre-wrap;

        word-wrap:break-word;

        overflow-wrap:break-word;

        overflow-x:auto;

        font-size:18px;

        line-height:2;

        font-family:Verdana,sans-serif;

        color:#ffffff;

    }

    b{

        color:#ffffff;

        font-size:20px;

    }

</style>
                </head>

                <body>

                    <div class="card">

                        <h1>AI ChatBot</h1>

                        <div class="user">

                            <b>You:</b>

                            <br><br>

                            %s

                        </div>

                        <div class="ai">

                            <b>AI:</b>

                            <br><br>

                            <pre>%s</pre>

                        </div>

                    </div>

                </body>

                </html>

                """.formatted(message, response);
    }
}