package nl.han.se.bewd.mockworkshop.toets;

import nl.han.se.bewd.mockworkshop.resultaat.ToetsResultaatRegistratieDB;
import nl.han.se.bewd.mockworkshop.student.Student;
import nl.han.se.bewd.mockworkshop.vak.Vak;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToetsTest {

    @InjectMocks
    Toets sut;

    @Mock
    Student mockStudent;

    @Mock
    ToetsResultaatRegistratieDB mockDB;

    @Test
    void opdracht10getToetsCijferVoorStudentGeeftToetsCijferVoorStudent() {
        // Arrange
        Student testStudent = new Student();
        Summatief toets1 = new faketest();
        Vak vak = new Vak(List.of(toets1));
        // Act
        int result = vak.getVakCijferForStudent(testStudent);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void opdracht10getToetsCijferVoorStudentGeeftToetsCijferVoorStudent2() {
        // Arrange

        when(mockDB.vraagResultatenOp(mockStudent)).thenReturn(List.of("2"));

        // Act
        int result = sut.getToetsCijferVoorStudent(mockStudent);

        // Assert
        assertEquals(2, result);
    }

    @Test
    void opdracht10getToetsCijferVoorStudentGeeftToetsCijferVoorStudent3() {
        // Arrange


        when(mockDB.vraagResultatenOp(mockStudent)).thenReturn(List.of("1","2","3"));

        // Act
        int result = sut.getToetsCijferVoorStudent(mockStudent);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void opdracht10getToetsCijferVoorStudentGeeftToetsCijferVoorStudent4() {
        // Arrange


        when(mockDB.vraagResultatenOp(mockStudent)).thenReturn(List.of("10","2","3"));

        // Act
        int result = sut.getToetsCijferVoorStudent(mockStudent);

        // Assert
        assertEquals(10, result);
    }



}