import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    public int makeMove() {
        return random.nextInt(9);
    }
}
