---
id: java-commands-01
title: Essential Java Commands for Boot 4 Developers
summary: Quick commands to inspect, build, and troubleshoot Java applications.
module: modern-java-foundation
type: command
minLevel: newbie
targetOS: any
order: 60
tags: [java, commands]
estimatedMinutes: 10
---

## JDK inspection

```bash
java -version
jshell --version
jcmd -l
```

```powershell
java -version
jshell --version
jcmd -l
```

## Profiling basics

```bash
jcmd <pid> VM.native_memory summary
jcmd <pid> GC.heap_info
```

```powershell
jcmd <pid> VM.native_memory summary
jcmd <pid> GC.heap_info
```

### Best practice

> **Best Practice:** Capture a heap and thread dump before restarting production services.

