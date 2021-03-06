package com.meituan.hotel.rec.service.recall.implement;

import com.meituan.hotel.rec.service.common.PoiEntry;
import com.meituan.hotel.rec.service.common.PoiSource;
import com.meituan.hotel.rec.service.common.RecResponse;
import com.meituan.hotel.rec.service.constants.JmonitorKey;
import com.meituan.hotel.rec.service.constants.MedisClient;
import com.meituan.hotel.rec.service.recall.IRecaller;
import com.meituan.hotel.rec.service.recall.common.RecallRequest;
import com.meituan.hotel.rec.thrift.Location;
import com.meituan.hotel.rec.thrift.RecServiceStatus;
import com.meituan.jmonitor.JMonitor;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zuolin02 and iangweisen on 3/15/16
 */
@Service("poi-corr-v2p-llr-recaller")
public class PoiCorrV2PLLRRecaller implements IRecaller {
    public static final String STRATEGY = "poiCorrV2PLLRRecallerStrategy";

    @Override
    public RecResponse recall(RecallRequest request, JSONObject joLog) {
        long start = System.currentTimeMillis();

        RecResponse response = RecResponse.getErrorResponse();
        if (CollectionUtils.isEmpty(request.getPoiOnShow())){
            response.setStrategy(STRATEGY);
            response.setServiceStatus(RecServiceStatus.ERROR);
            return response;
        }

        int poiId = request.getPoiOnShow().get(0);
        Location reqLocation = request.getRequestLocation();
        double poiLat = reqLocation.getLattitude();
        double poiLng = reqLocation.getLongitude();

        List<PoiEntry> poiEntryList = PoiCorrV2PRecaller.readMedisData(poiId, poiLng, poiLat,
                MedisClient.POI_V2P_LLR_CORR_PREFIX_KEY);

        for (PoiEntry e: poiEntryList){
            e.setSource(PoiSource.CORR_LLR);
        }

        response.setServiceStatus(RecServiceStatus.OK);
        response.setPoiEntryList(poiEntryList);
        response.setStrategy(STRATEGY);

        long timeCost = System.currentTimeMillis() - start;
        JMonitor.add(JmonitorKey.CITY_POI_RECALL_CORR_TIME, timeCost);

        return response;
    }
}
