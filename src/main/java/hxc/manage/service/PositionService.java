package hxc.manage.service;

import hxc.manage.model.Position;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:28
 */
public interface PositionService {
    List<Position> getAllPos();

    int addPos(Position pos);

    boolean deletePosById(String pids);

    int updatePosById(Position position);
}
