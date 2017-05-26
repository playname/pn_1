# PN

This is an interpreter I made for my scritpting language "PN" (PlayName).
Feel free to make improvements to it.

### Arguments

  pn [-d (DEBUG)] [-v (VERSION)] [PATH TO FILE]
  
  -d activates the debug mode.
  -v shows the version of the program.
  

### Commands

  add [VARIABLE], [VALUE]
  sub [VARIABLE], [VALUE]
  mul [VARIABLE], [VALUE]
  div [VARIABLE], [VALUE]

  addV [VARIABLE], [VARIABLE]
  subV [VARIABLE], [VARIABLE]
  mulV [VARIABLE], [VARIABLE]
  divV [VARIABLE], [VARIABLE]
  
  get [VARIABLE]  Reads text input and stores it in the given variable.
  print [TEXT]
  println [TEXT]
  printVar [VARIABLE]
  printlnVar [VARIABLE]
  
  if [VARIABLE] [==, <, >] [VARIABLE] //NOT THE BEST "IF"
  endif
  
  exit [CODE]
  
  call [FUNCTION]
  ret
  jmp [LINE]
  
  push [VALUE]
  pushVar [VARIABLE]
  pop [VARIABLE]


### Variables

  var [NAME]: [TYPE] = "[VALUE]"
  
  Datatypes: int, float, bool, string //EVERYTHING IS JUST A STRING
  

### Functions

  void [NAME]


### Comments

  "// " is a comment (space after "//" is required)
