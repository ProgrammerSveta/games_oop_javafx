package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPathIsOK() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] actual = bishop.way(Cell.E3);
        Cell[] expected = {Cell.D2, Cell.E3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void whenPathIsNotOK() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishop.way(Cell.C2));
        assertThat(exception.getMessage()).isEqualTo("Can't move from C1 to C2");
    }

    @Test
    public void whenCopyIsOK() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Assertions.assertEquals(bishop.copy(Cell.D2).position(), Cell.D2);
    }

    @Test
    public void whenPositionIsOK() {
        BishopBlack bishop = new BishopBlack(Cell.D3);
        Assertions.assertEquals(Cell.D3, bishop.position());
    }
}