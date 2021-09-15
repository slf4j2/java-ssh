package com.example.java.ssh.controller;

import com.example.java.ssh.config.JavaSsh;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author soho.chan
 * @date 15/9/2021 14:14
 */
@RestController
@RequestMapping("/ssh")
public class CommandController {
    private static final String HOST = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    @GetMapping("/run")
    public ResponseEntity<String> run() {
        String[] cmds = {
                USERNAME,
                PASSWORD,
                "cd /u01/wip/online_script",
                "ant check1",
                "cat test1.csv"
        };
        try {
            // 執行脚本命令
            String executive = JavaSsh.create(HOST).executive(cmds, null);
            return new ResponseEntity<>(executive, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
