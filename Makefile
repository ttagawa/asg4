#Name:Tyler Tagawa CruzID:1360833 class:cmps 12b
#date:12/8/14 filename:Makefile
#description:compiles and runs cyoa with demo.adventure
JAVASRC    = cyoa.java auxlib.java tree.java
SOURCES    = ${JAVASRC} Makefile
MAINCLASS  = cyoa
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

all: ${CLASSES}

clean:
	rm -f *.class

test: all
	java ${MAINCLASS} demo.adventure

.PHONY: clean all test