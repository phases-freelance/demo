/**
 * 
 */
package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.ResponseData;
import com.example.demo.entity.Branch;
import com.example.demo.service.CostByDateService;

/**
 * @author arockia
 *
 */
@RestController
@RequestMapping("/api")
public class CostByDateController {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	@Autowired
	private CostByDateService costByDateService;
	
	@GetMapping(value = "/findByDate/{date}")
	public List<BranchDto> findByDate(@PathVariable("date") String date) {
		Date date1;
		List<BranchDto> branchList = new ArrayList<>();
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			branchList = costByDateService.findByDate(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return branchList;
	}
	
	@GetMapping(value = "/findBetweenDates")
	public ResponseData findBetweenDates(@RequestParam(name = "fromDate", required = false) String fromDate, @RequestParam(name = "toDate", required = false) String toDate) {
		List<BranchDto> branchList = new ArrayList<>();
		ResponseData responseData= new ResponseData();
		try {

			if (fromDate == null || fromDate.isEmpty() && toDate == null || toDate.isEmpty()) {
                List<String>daysList = getLast7DaysDates();
                Date strStartDate = new SimpleDateFormat("dd-MM-yyyy").parse(daysList.get(0));
                Date strEndDate = new SimpleDateFormat("dd-MM-yyyy").parse(daysList.get(daysList.size() - 1));
                branchList = costByDateService.findBetweenDates(strStartDate, strEndDate);
			} else {
                Date fromDateStr = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
                Date toDatestr = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
                branchList = costByDateService.findBetweenDates(fromDateStr, toDatestr);
			}
			responseData.setData(branchList);
			responseData.setRecordsTotal(branchList.size());
			responseData.setRecordsFiltered(branchList.size());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseData;
	}

    public static List<String> getLast7DaysDates() {
        List<String> last7Days = new ArrayList<>();
        LocalDate weekBeforeToday = LocalDate.now().minusDays(7);
        IntStream.rangeClosed(1, 7)
                .mapToObj(weekBeforeToday::plusDays)
                .forEach(d -> {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
                    last7Days.add(d.format(dateTimeFormatter));
                });
        return last7Days;
    }

}
