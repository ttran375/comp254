class Student:
    def __init__(self, studentId, studentName, studentEmail):
        self.studentId = studentId
        self.studentName = studentName
        self.studentEmail = studentEmail

    def getStudentId(self):
        return self.studentId

    def setStudentId(self, studentId):
        self.studentId = studentId

    def getStudentName(self):
        return self.studentName

    def setStudentName(self, studentName):
        self.studentName = studentName

    def getStudentEmail(self):
        return self.studentEmail

    def setStudentEmail(self, studentEmail):
        self.studentEmail = studentEmail

    def __str__(self):
        return f"Student[studentId={self.studentId}, studentName='{self.studentName}', studentEmail='{self.studentEmail}']"
