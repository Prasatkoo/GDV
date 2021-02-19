package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate)  {
        Coordinate[] cords = (Coordinate[])this.selectedPoints.toArray(new Coordinate[0]);
        int[][] triangle = new int[3][2];
        int i = 0;
        for (Coordinate randomcords : getSelectedPoints()) {
            triangle[i][0] = randomcords.getX();
            triangle[i][1] = randomcords.getY();
            i++;

        }

        return (
                (float) (coordinate.getX() - triangle[1][0]) * (triangle[2][1] - triangle[1][1]) - (coordinate.getY() -
                        triangle[1][1]) * (triangle[2][0] - triangle[1][0]) < 0  &&
                        (float) (coordinate.getX() - triangle[2][0]) * (triangle[0][1] - triangle[2][1]) - (coordinate.getY()
                                - triangle[2][1]) * (triangle[0][0] - triangle[2][0]) < 0  &&
                        (float) (coordinate.getX() - triangle[0][0]) * (triangle[1][1] - triangle[0][1]) - (coordinate.getY()
                                - triangle[0][1]) * (triangle[1][0] - triangle[0][0]) < 0 );



    }


}

