# 如何使用

修改 com.example.java.ssh.controller.CommandController host用戶名以及密碼
```
    private static final String HOST = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
```

修改 run() 方法中執行的指令, 逗號分割代表執行一個命令
```
String[] cmds = {
                USERNAME,
                PASSWORD,
                "cd /u01/wip/online_script",
                "ant check1",
                "cat test1.csv"
}
```

啓動項目調用 localhost:8080/ssh/run 執行命令