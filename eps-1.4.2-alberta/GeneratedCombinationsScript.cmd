SPECIAL>NOINTERACTION
SPECIAL>LOADMODEL|"EPS.mdl"
SIMULATE>RUNNAME|MostRecentRun

SIMULATE>SETVAL|LDVs Feebate Rate=0
SIMULATE>SETVAL|Boolean Improved Device Labeling=0
SIMULATE>SETVAL|Carbon Tax[transportation sector]=0
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|||||:MostRecentRun	CurrentRunNumber=1	Feebate=0	ImprovedLabeling=0	CarbonTaxTrans=0

SIMULATE>SETVAL|LDVs Feebate Rate=0
SIMULATE>SETVAL|Boolean Improved Device Labeling=0
SIMULATE>SETVAL|Carbon Tax[transportation sector]=300
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=2	Feebate=0	ImprovedLabeling=0	CarbonTaxTrans=300

SIMULATE>SETVAL|LDVs Feebate Rate=0
SIMULATE>SETVAL|Boolean Improved Device Labeling=1
SIMULATE>SETVAL|Carbon Tax[transportation sector]=0
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=3	Feebate=0	ImprovedLabeling=1	CarbonTaxTrans=0

SIMULATE>SETVAL|LDVs Feebate Rate=0
SIMULATE>SETVAL|Boolean Improved Device Labeling=1
SIMULATE>SETVAL|Carbon Tax[transportation sector]=300
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=4	Feebate=0	ImprovedLabeling=1	CarbonTaxTrans=300

SIMULATE>SETVAL|LDVs Feebate Rate=1
SIMULATE>SETVAL|Boolean Improved Device Labeling=0
SIMULATE>SETVAL|Carbon Tax[transportation sector]=0
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=5	Feebate=1	ImprovedLabeling=0	CarbonTaxTrans=0

SIMULATE>SETVAL|LDVs Feebate Rate=1
SIMULATE>SETVAL|Boolean Improved Device Labeling=0
SIMULATE>SETVAL|Carbon Tax[transportation sector]=300
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=6	Feebate=1	ImprovedLabeling=0	CarbonTaxTrans=300

SIMULATE>SETVAL|LDVs Feebate Rate=1
SIMULATE>SETVAL|Boolean Improved Device Labeling=1
SIMULATE>SETVAL|Carbon Tax[transportation sector]=0
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=7	Feebate=1	ImprovedLabeling=1	CarbonTaxTrans=0

SIMULATE>SETVAL|LDVs Feebate Rate=1
SIMULATE>SETVAL|Boolean Improved Device Labeling=1
SIMULATE>SETVAL|Carbon Tax[transportation sector]=300
SIMULATE>SETVAL|Policy Implementation Schedule Selector=1
MENU>RUN|O
MENU>VDF2CSV|MostRecentRun.vdf|RunResults.tsv|OutputVarsToExport.lst|+!||||:MostRecentRun	CurrentRunNumber=8	Feebate=1	ImprovedLabeling=1	CarbonTaxTrans=300
MENU>EXIT
