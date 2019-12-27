package hxc.manage.service.impl;

import hxc.manage.mapper.PositionMapper;
import hxc.manage.service.PositionService;
import hxc.manage.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 14:26
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;

    public int addPos(Position pos) {
        if (positionMapper.getPosByName(pos.getName()) != null) {
            return -1;
        }
        return positionMapper.addPos(pos);
    }

    public List<Position> getAllPos() {
        return positionMapper.getAllPos();
    }

    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        return positionMapper.deletePosById(split) == split.length;
    }

    public int updatePosById(Position position) {
        return positionMapper.updatePosById(position);
    }

}
