Maestro CLI
====

Um TODO list baseado em tags


Entidades
===

Task
---
id
supertask -> Task
name


Tag
---
id
name


Attribute
---
id
name
tag -> Tag
type -> AttributeType


AttributeType
---
VIEW, FIXEDTAGLIST, REGEXTAGLIST, TEXT, DATETIME, INTEGER, GPS


TaskTag
---
id
task -> Task
tag -> Tag


TagProperty
---
id
taskTag -> TaskTag
attribute -> TagAttribute
value


Roadmap
===

Versão 0.1
---

*  tag add <nome>
*  tag ls
*  attr add <nome tag> <nome atributo> <type>
*  attr ls [nome tag]
*  task add <nome> \[ --supertaskid=<super task id> ] [ --tags=<tags separadas por ,> ]
*  task ls


Futuro
---
* Tag automática com a data de criação da tarefa
    * Talvez montar tags desse tipo para ter todo o histórico da tarefa
* Fazer parser de query para task ls:
   --query="expressao"
  *  <expressao>: <operando> [<operador binário> <operando>]
  *  <operando>: [ nome_tag | nome_tag(valor_atributo1,valor_atributo2...) | subtaskof @<task id> ]
  *  <operador binário>: [ and | or ]